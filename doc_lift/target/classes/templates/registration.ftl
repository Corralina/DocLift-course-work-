<#import "parts/DOM.ftl" as dom>
<#import "parts/autentification_form.ftl" as login>
<#import "parts/panel.ftl" as panel>
<@dom.dom>
Add new user
${message?ifExists}
<div>
<@login.login "/registration"/>
</div>
</@dom.dom>