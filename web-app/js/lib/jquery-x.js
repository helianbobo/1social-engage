// Extension for jQuery and more
;define(['backbone', 'mustache'], function() {
(function($) {

  $.pagination = function(el) {
    function goto(to) {
      return function() {
        el.trigger('go', to)
        return false
      }
    }
    function guard(fn) {
      return function(evt) {
        var btn = $(this)

        if (btn.hasClass('disabled')) return false;
        return fn(btn)
      }
    }

    el.on('change', function(evt, data) {
        var max = Math.min(data.offset + data.pageSize, data.total)
        el.find('.offset').html(data.offset + 1)
        el.find('.max').html(max)
        el.find('.total').html(data.total)
        el.find('.prev, .next').removeClass('disabled')
        if (!data.offset) el.find('.prev').addClass('disabled')
        if (max >= data.total) el.find('.next').addClass('disabled')
      }
    )
    
    el.delegate('.prev', 'click', guard(goto('prev')))
    el.delegate('.next', 'click', guard(goto('next')))
    return el
  }

  /**
   * Return the offset relative to ref, default is body.
   *
   * Notes: The ref element should be 'absolute' or 'relative' position.
   *        If you get the incorrect offfset, check the ref position setting first.
   */
  $.relativeOffset = function(sender, ref) {
      if (sender && sender.jquery) sender = sender[0]
      if (!sender) return;
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
              if (E === ref) break all;
              x-= E.scrollLeft
              y-= E.scrollTop
          } while (ref === (E = E.parentNode) || e !== E)
      }
      return { left: x, top: y }
  }

  $.fn.copyAttr = function(from, to) {
    return this.each(function(i, it) {
      var el = $(it)

      if (el.attr(from)) el.attr(to, el.attr(from))
    })
  }
})(jQuery)

_.extend(_, {
  /**
   * Equals joinPath('/', p1, p2, ...)
   */
  absolutePath: function(p1, p2 /* [, px] */) {
    return _.joinPath.apply(null, Array.prototype.concat.apply(['/'], arguments))
  }
  
  /**
   * array2Object(['a', 'b'], [0, 1]) 
   * // { a: 0, b: 1 }
   *
   * array2Object(['a', 'b'], [0, 1], [2, 3]) 
   * // [{ a: 0, b: 1 }, { a: 2, b: 3 }]
   */
, array2Object: function(keys, values) {
    function map(keys, values) {
      var obj = {}
      _.each(keys, function(key, i) { obj[key] = values[i] })
      return obj
    }
    if (arguments.length > 2) {
      return _.map(_.rest(arguments), function(arr) { return map(keys, arr)})
    } else return map(keys, values)
  }

, capitalize: function(str) {
    return str.replace(/^[a-z]/, function(a) { return a.toUpperCase() })
  }
  
  /**
   * Examples:
   * 
   * joinPath('aaa/', '/bbb') // 'aaa/bbb'
   * joinPath('aaa', 'bbb', '', 'ccc', '/', 'ddd') // 'aaa/bbb/ccc/ddd'
   */
, joinPath: function(p1, p2 /* [, px] */) {
    return _.reduce(arguments, function(s1, s2) {
          var _s1 = s1.replace(/\/$/, '')
          s2 = s2.replace(/^\//, '')
          if (!_s1 && s1 != '/') return s2
          if (!s2) return s1

          return _s1 + '/' + s2
        })
  }

, toCamelCase: function(str) {
    return str.replace(/\-([a-z])/g, function(a, b) { return b.toUpperCase() })
  }
})

// Backbone extensions
var Backbone = window.Backbone

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

})