from setuptools import setup, find_packages

setup (
  name = 'co2 lexer and style',
  packages = find_packages(),
  entry_points = {
    "pygments.lexers" : [ "co2 = co2:CO2Lexer" ],
    "pygments.styles" : [ "eclipse = eclipse:EclipseStyle"]
  }
)