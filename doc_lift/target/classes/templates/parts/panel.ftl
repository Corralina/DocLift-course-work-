<#include "security.ftl">
<#import "autentification_form.ftl" as au_f>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Documet lift</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/registers">list register </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/newRegister">new registers </a>
                </li>
<#--                <#if isAdmin>-->
                <li class="nav-item">
                    <a class="nav-link" href="/registration">registration</a>
                </li>
<#--                </#if>-->
            </ul>
            <div class="navbar-text">${name}</div>
            <div><@au_f.logaut></@au_f.logaut></div>
        </div>
    </nav>
