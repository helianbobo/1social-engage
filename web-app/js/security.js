define(['lib/jquery-x'], function() {

  var settings = {
        roles: []
      }

  function ifNoRoles() {
    return settings.roles.length === 0
  }

  return _.extend({
    ifAllGranted: function(role/* , role2... */) {
      return ifNoRoles() || _.every(arguments, function(it) { return _.indexOf(settings.roles, it) != -1 })
    }

  , ifAnyGranted: function(role/* , role2... */) {
      return ifNoRoles() || _.any(arguments, function(it) { return _.indexOf(settings.roles, it) != -1 })
    }

  , setup: function(options) {
      settings.roles = options
      this.trigger('ready')
    }
  }, Backbone.Events)
})