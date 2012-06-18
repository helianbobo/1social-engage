<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <g:render template="/share/title" model="[currentModule: 'socialEngage', currentSubModule: currentSubModule]"/>
    <g:render template="/share/head"/>

    <title><g:layoutTitle/></title>

    <r:require module="engage"/>

    <g:layoutHead/>
    <r:layoutResources/>

    <g:render template="/share/session" model="[currentModule: 'socialEngage', currentSubModule: currentSubModule]" />
</head>

<body>

<g:render template="/share/header"
          model="[subModules:['posts','cases'], currentModule: 'socialEngage', currentSubModule:currentSubModule]"/>



<g:layoutBody/>

<r:layoutResources/>
</body>
</html>