# Diogenes Documentation
[![Build Status](https://travis-ci.org/diogenes-lang/diogenes-doc.svg?branch=master)](https://travis-ci.org/diogenes-lang/diogenes-doc)

## Requirements

The documentation is generated in Python (both version 2 and 3 are tested with Travis CI).

Use `pip` to install the following Python packages:

```
pip install sphinx pygments sphinxcontrib-inlinesyntaxhighlight
```

## Available commands

```shell
$ make
Please use `make <target>' where <target> is one of
  build                to build the documentation
  clean                to clean the documentation
  build-fatal-warnings to build the documentation and fail if there are warnings
  install-lexer        to install the lexer and the style
  remove-lexer         to remove the lexer and the style
  full-build           to install the lexer and build the documentation
  full-clean           to remove the lexer and clean the documentation
  loop                 to start a loop that search for changes and rebuild the documentation if there are any
  server               to start an http server using Python 3
  server2              to start an http server using Python 2

 Other commands
  html       to make standalone HTML files
  dirhtml    to make HTML files named index.html in directories
  singlehtml to make a single large HTML file
  pickle     to make pickle files
  json       to make JSON files
  htmlhelp   to make HTML files and a HTML help project
  qthelp     to make HTML files and a qthelp project
  applehelp  to make an Apple Help Book
  devhelp    to make HTML files and a Devhelp project
  epub       to make an epub
  latex      to make LaTeX files, you can set PAPER=a4 or PAPER=letter
  latexpdf   to make LaTeX files and run them through pdflatex
  latexpdfja to make LaTeX files and run them through platex/dvipdfmx
  text       to make text files
  man        to make manual pages
  texinfo    to make Texinfo files
  info       to make Texinfo files and run them through makeinfo
  gettext    to make PO message catalogs
  changes    to make an overview of all changed/added/deprecated items
  xml        to make Docutils-native XML files
  pseudoxml  to make pseudoxml-XML files for display purposes
  linkcheck  to check all external links for integrity
  doctest    to run all doctests embedded in the documentation (if enabled)
  coverage   to run coverage check of the documentation (if enabled)


```
