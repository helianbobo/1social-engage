jQuery(function($){
    /**
     * CheckAll, if the checkbox with checkall class is checked/unchecked all checkbox would be checked
     * */
    $('#content .checkall').change(function(){
        $(this).parents('table:first').find('input').attr('checked', $(this).is(':checked')); 
    });
    
    /** 
     * Sidebar menus
     * Slidetoggle for menu list
     * */
    var currentMenu = null; 
	 

    $('#sidebar>ul>li').each(function(){
        if($(this).find('li').length == 0){
            $(this).addClass('nosubmenu');
        }
		
    })


 $('#sidebar>ul>li.active').find('ul:first').hide();
    $('#sidebar>ul>li([class*="nosubmenu"])>a').click(function(){
	 
       e = $(this).parent();
	  
       $('#sidebar>ul>li.current').removeClass('current').find('ul:first').hide();
	      $('#sidebar>ul>li.active').removeClass('active');
        e.addClass('active');
	
    });

     $('#sidebar>ul>li:not([class*="current"])>ul').hide();
     $('#sidebar>ul>li>a').mouseover(function(){
      e = $(this).parent();
       $('#sidebar>ul>li.current').removeClass('current').find('ul:first').hide();
       $('#sidebar>ul>li.active').find('ul:first').hide();
       e.addClass('current').find('ul:first').slideDown();
	});



    $('#sidebar>ul>li([class*="current"])>ul').hide();
    $('#sidebar>ul>li:not([class*="nosubmenu"])>a').mouseout(function(){
        e = $(this).parent();
       $('#sidebar>ul>li.current').removeClass('current').find('ul:first').hide();
       e.removeClass('current').find('ul:first').hide();
	$('#sidebar>ul>li.active').find('ul:first').show();
	    
    });


    var htmlCollapse = $('#menucollapse').html(); 
    if($.cookie('isCollapsed') === 'true'){
      $('body').addClass('collapsed'); 
      $('#menucollapse').html('&#9654;');
    } 
    $('#menucollapse').click(function(){
      var body = $('body'); 
      body.toggleClass('collapsed');
      isCollapsed = body.hasClass('collapsed');
      if(isCollapsed){
        $(this).html('&#9654;');
      }else{
        $(this).html(htmlCollapse); 
      }
      $.cookie('isCollapsed',isCollapsed); 
      return false; 
    });

	/*sub menu item*/
	    $('#sidebar>ul>ul>li([class*="nosubmenu"])>a').click(function(){
	 
       e = $(this).parent();
	  
       $('#sidebar>ul>ul>li.current').removeClass('current').find('ul:first').hide();
	      $('#sidebar>ul>li.active').removeClass('active');
        e.addClass('active');
	
    });
	

    });
