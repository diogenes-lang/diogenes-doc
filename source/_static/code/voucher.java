package it.unica.co2.site.voucher;


import static it.unica.co2.api.contract.utils.ContractFactory.*;
import it.unica.co2.api.contract.ContractDefinition;
import it.unica.co2.api.contract.Recursion;
import it.unica.co2.api.contract.SessionType;
import it.unica.co2.api.contract.Sort;
import it.unica.co2.api.process.CO2Process;
import it.unica.co2.api.process.Participant;
import it.unica.co2.honesty.HonestyChecker;
import co2api.ContractException;
import co2api.ContractExpiredException;
import co2api.Message;
import co2api.Public;
import co2api.Session;
import co2api.SessionI;
import co2api.TimeExpiredException;

/*
 * auto-generated by co2-plugin
 * creation date: 02-12-2016 15:31:31
 */
@SuppressWarnings("unused")
public class Main {
	
	private static final String username = "eclipse@co2.unica.it";
	private static final String password = "eclipse";
	
	static final Integer intPlaceholder = 42;
	
	
	/*
	 * contracts declaration
	 */
	static final ContractDefinition CB = def("CB");
	static final ContractDefinition CV = def("CV");
	
	/*
	 * contracts initialization
	 */
	static {
		CB.setContract(externalSum().add("clickPay", Sort.unit(), externalSum().add("pay", Sort.string())).add("clickVoucher", Sort.unit(), internalSum().add("reject", Sort.unit(), externalSum().add("pay", Sort.string())).add("accept", Sort.unit(), externalSum().add("voucher", Sort.string()))));
		CV.setContract(externalSum().add("ok", Sort.unit()).add("no", Sort.unit()));
	}
	
	
	public static class P extends Participant {
		
		private static final long serialVersionUID = 1L;
		
		public P(String username, String password) {
			super(username, password);
		}
		
		@Override
		public void run() {
			Session<SessionType> x = tellAndWait(Main.CB);
			
			logger.info("waiting on 'x' for actions [clickPay, clickVoucher]");
			Message msg = x.waitForReceive("clickPay", "clickVoucher"); 
			
			switch (msg.getLabel()) {
				case "clickPay":
					logger.info("received ["+msg.getLabel()+"]");
					logger.info("waiting on 'x' for actions [pay]");
					Message msg1 = x.waitForReceive("pay"); 
					
					logger.info("received [pay]");
					String code;
					code = msg1.getStringValue();
					break;
				case "clickVoucher":
					logger.info("received ["+msg.getLabel()+"]");
					Public<SessionType> pbl_y = tell(Main.CV, Main.intPlaceholder*1000); 
					
					try {
						Session<SessionType> y = pbl_y.waitForSession();
						
						processCall(Q.class, username, password ,x, y); 
					}
					catch(ContractExpiredException e) {
						//retract y
						logger.info("sending action 'reject'");
						x.sendIfAllowed("reject"); 
						
						logger.info("waiting on 'x' for actions [pay]");
						Message msg2 = x.waitForReceive("pay"); 
						
						logger.info("received [pay]");
						String code1;
						code1 = msg2.getStringValue();
					}
					break;
			}
		}
	}
	
	public static class Q extends Participant {
		
		private static final long serialVersionUID = 1L;
		private SessionI<SessionType> x;
		private SessionI<SessionType> y;
		
		public Q(String username, String password, SessionI<SessionType> x, SessionI<SessionType> y) {
			super(username, password);
			this.x=x;
			this.y=y;
		}
		
		@Override
		public void run() {
			try {
				logger.info("waiting on 'y' for actions [ok, no]");
				Message msg = y.waitForReceive(Main.intPlaceholder*1000, "ok", "no"); //TODO: remove the placeholder/s
				
				switch (msg.getLabel()) {
					case "ok":
						logger.info("received ["+msg.getLabel()+"]");
						logger.info("sending action 'accept'");
						x.sendIfAllowed("accept"); 
						
						logger.info("waiting on 'x' for actions [voucher]");
						Message msg1 = x.waitForReceive("voucher"); 
						
						logger.info("received [voucher]");
						String v;
						v = msg1.getStringValue();
						break;
					case "no":
						logger.info("received ["+msg.getLabel()+"]");
						logger.info("sending action 'reject'");
						x.sendIfAllowed("reject"); 
						
						logger.info("waiting on 'x' for actions [pay]");
						Message msg2 = x.waitForReceive("pay"); 
						
						logger.info("received [pay]");
						String code;
						code = msg2.getStringValue();
						break;
				}
			}
			catch (TimeExpiredException e) {
				processCall(R.class, username, password ,x, y); 
			}
			
		}
	}
	
	public static class R extends Participant {
		
		private static final long serialVersionUID = 1L;
		private SessionI<SessionType> x;
		private SessionI<SessionType> y;
		
		public R(String username, String password, SessionI<SessionType> x, SessionI<SessionType> y) {
			super(username, password);
			this.x=x;
			this.y=y;
		}
		
		@Override
		public void run() {
			
			parallel(()->{
				logger.info("sending action 'reject'");
				x.sendIfAllowed("reject"); 
				
				logger.info("waiting on 'x' for actions [pay]");
				Message msg = x.waitForReceive("pay"); 
				
				logger.info("received [pay]");
				String code;
				code = msg.getStringValue();
			});
			
			parallel(()->{
				logger.info("waiting on 'y' for actions [ok, no]");
				Message msg1 = y.waitForReceive("ok", "no"); 
				
				switch (msg1.getLabel()) {
					case "ok":
					case "no":
						logger.info("received ["+msg1.getLabel()+"]");
						break;
				}
			});
		}
	}
	
	public static void main(String[] args) {
		HonestyChecker.isHonest(P.class, Main.username, Main.password);
		//new Thread(new P(Main.username, Main.password)).start();
	}
}
