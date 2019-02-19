.. Diogenes documentation master file, created by
   sphinx-quickstart on Tue Feb 23 11:22:46 2016.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Diogenes: finding honest Java programs (without a lamp)
=======================================================

Diogenes is a tool which supports programmers in writing **honest** contract-oriented Java programs.
In this context, honesty means always respecting the contracts one advertises, in all possible execution contexts.
Honest programs are **never sanctioned** by the contract-oriented infrastructure; further, compositions of honest services are **deadlock-free**.

The main features of Diogenes are:

* an Eclipse plugin to write CO2 specifications of services

* an honesty checker for CO2 specifications

* a translator from CO2 to Java programs interacting with the      `contract-oriented infrastructure <http://co2.unica.it>`_

* an honesty checker for Java programs upon refinement

---------------------------------------------------------------

Contents:

.. toctree::
   :maxdepth: 3

   installation
   first-project
   examples
   papers
   contact

..   lang-spec


