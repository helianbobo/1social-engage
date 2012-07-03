// Extension for jQuery and more
(function($) {
  // TODO
})(jQuery)

// -----
function capitalize(str) {
  return str.replace(/^[a-z]/, function(a) { return a.toUpperCase() })
}

/**
 * Examples:
 * 
 * joinPath('aaa/', '/bbb') // 'aaa/bbb'
 * joinPath('aaa', 'bbb', '', 'ccc', '/', 'ddd') // 'aaa/bbb/ccc/ddd'
 */
function joinPath(p1, p2 /* [, px] */) {
  return _.reduce(arguments, function(s1, s2) {
        s1 = s1.replace(/\/$/, '')
        s2 = s2.replace(/^\//, '')
        if (!s1) return s2
        if (!s2) return s1
        return s1.replace(/\/$/, '') + '/' + s2.replace(/^\//, '')
      }
    )
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

  var viewExt = {
        extractTemplate: function(el) {
          return $('<div></div>').append(el).html()
        }

      , reset: function() {
          this.remove()
          delete this.$el
          delete this.el
          this.trigger('reset')
          this.off()
        }
      }

  viewExt.destroy = viewExt.reset
  _.extend(Backbone.View.prototype, viewExt)
}