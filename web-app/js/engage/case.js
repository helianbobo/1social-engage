$(document.body).ready(function() {
  function repeat(ul, max) {
    var li = ul.find('li')
      , max = max || 12

    for(var i = 0; i < max; i++) ul.append(li.clone())
  }

  repeat($('.comments ul'))
  repeat($('.case-history-wrap ul'), 50)
})