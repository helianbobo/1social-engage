// Extension for jQuery and more
(function($) {
  // TODO
})(jQuery)

function array2Object(keys, values) {
  function map(keys, values) {
    var obj = {}
    _.each(keys, function(key, i) { obj[key] = values[i] })
    return obj
  }
  if (arguments.length > 2) {
    return _.map(_.rest(arguments), function(arr) { return map(keys, arr)})
  } else return map(keys, values)
}

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
  var one = function(event, callback, context) {
        var _t = this
          , fn = function() {
              _t.off(event, fn, context)
              if ($.isFunction(callback)) callback.apply(this, arguments)
            }

        _t.on(event, fn, context)
      }

  Backbone.Events.one = one
  Backbone.Model.prototype.one = one
  Backbone.Collection.prototype.one = one

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