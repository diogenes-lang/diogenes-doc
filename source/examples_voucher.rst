===========================
Voucher distribution system
===========================

A store offers buyers two payments options:
**clickPay** or **clickVoucher**. If a buyer chooses **clickPay**,
the store requires it to **pay**;
otherwise, the store check the validity of the voucher interacting
with an online voucher distribution system (*V*).
If *V* validates the voucher (**ok**), the buyer can use it (**voucher**),
otherwise (**no**) it must **pay** the store.



:download:`voucher.co2 <_static/code/voucher.co2>`

:download:`voucher.java <_static/code/voucher.java>`

.. container:: codeset

    .. container:: codeset-co2

        .. literalinclude:: _static/code/voucher.co2
           :language: co2
           :linenos:

    .. container:: codeset-java

        .. literalinclude:: _static/code/voucher.java
           :language: java
           :linenos:

