function toCamelCase(str) {
  return str.replace(/\-([a-z])/g, function(a, b) { return b.toUpperCase() })
}

function capitalize(str) {
  return str.replace(/^[a-z]/, function(a) { return a.toUpperCase() })
}