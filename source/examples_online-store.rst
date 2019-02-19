============
Online store
============

An online store has the following contract: buyers can iteratively 
add items to a shopping **cart**; 
when at least one item has been added,
a buyer can proceed to the **checkout**. 
Then, the client can either **cancel** the order, or **pay**.
In the latter case, the store can accept the payment (**ok**), 
or decline it (**no**, in which case it lets the user try again),
or it can **abort** the transaction.


:download:`onlinestore.co2 <_static/code/onlinestore.co2>`

:download:`onlinestore.java <_static/code/onlinestore.java>`

.. container:: codeset

    .. container:: codeset-co2

        .. literalinclude:: _static/code/onlinestore.co2
           :language: co2
           :linenos:

    .. container:: codeset-java

        .. literalinclude:: _static/code/onlinestore.java
           :language: java
           :linenos:

