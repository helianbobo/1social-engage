$(document.body).ready(function() {
  function copy(ul) {
    var li = ul.find('li');
    for(var i = 0; i < 12; i++) ul.append(li.clone())
  }

  copy($('.comments ul'))
})