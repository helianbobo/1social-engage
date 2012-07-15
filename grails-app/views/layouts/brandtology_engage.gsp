<!DOCTYPE html>
<html lang="en-US">

<head>
    <g:render template="/share/head"/>
    <g:render template="/share/title" 
    		model="[currentModule: 'socialEngage', currentSubModule: currentSubModule]"/>

    <g:layoutHead/>
    <r:layoutResources/>

    <g:render template="/share/session" 
    		model="[currentModule: 'socialEngage', currentSubModule: currentSubModule]" />
</head>

<body>

	
    <g:render template="/share/header"
        	model="[subModules:['posts','cases'], currentModule: 'socialEngage', currentSubModule:currentSubModule]"/>
    

	<g:layoutBody/>

	<r:layoutResources/>
</body>
</html>