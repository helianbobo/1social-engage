// Extension for jQuery and more
$.position = function( sender, ref ) {
  if (sender && sender.jquery) sender = sender[0]
  if (!sender) return
  if (ref && ref.jquery) ref = ref[0]
  if (!ref) ref = null

  var e = sender
    , E = e
    , x = E.scrollLeft
    , y = E.scrollTop

  all: while (e.offsetParent) {
    x += e.offsetLeft
    y += e.offsetTop
    e = e.offsetParent
    do {
      if (E === ref) break all
      x-= E.scrollLeft
      y-= E.scrollTop
    } while (ref === (E = E.parentNode) || e !== E)
  }
  return { "x": x, "y": y }
}

// -----
function capitalize(str) {
  return str.replace(/^[a-z]/, function(a) { return a.toUpperCase() })
}

function toCamelCase(str) {
  return str.replace(/\-([a-z])/g, function(a, b) { return b.toUpperCase() })
}


// Backbone extensions
var Backbone

if (Backbone) {
  Backbone.Events.one = function(event, callback) {
      var _t = this
        , fn = function() {
            if ($.isFunction(callback)) callback.apply(_t, arguments)
            _t.off(event, fn)
          }

      _t.on(event, fn)
    }
}