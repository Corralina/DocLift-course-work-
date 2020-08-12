<#import "parts/DOM.ftl" as dom>
<#import "parts/autentification_form.ftl" as login>
<#import "parts/panel.ftl" as panel>
<@dom.dom>
    ${message?if_exists}
    <div class="newR m-auto">

    <form action="/newRegister" method="post" enctype="multipart/form-data">
        <div class="row mt-5">
            <button class="btn btn-success m-3 " type="submit">Add regist</button>

        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-default">Document id</span>
            </div>
            <input name="doc_id" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-default">Coment</span>
            </div>
            <input name="comment" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
        </div>

        <div class="rd">
            <label class="m-3">Image  <input type="file" name="file" ></label>
        </div>
        <div class="rd">
            <#list collegues as collegues>
                <div class="form-check">
                    <input name="col${collegues.id}" class="form-check-input" type="checkbox" value="${collegues.id}" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        ${collegues.name}
                    </label>
                </div>
            </#list>
        </div>


    </form>
    </div>
</@dom.dom>