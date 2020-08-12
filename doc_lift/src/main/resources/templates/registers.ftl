<#import "parts/DOM.ftl" as dom>
<#import "parts/autentification_form.ftl" as login>
<#import "parts/panel.ftl" as panel>
<@dom.dom>
    <div class="row">
        <div class="col">
            Author
            <form action="/filterAuthor" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="text" name="filter" placeholder="serch by autor"/>
                <input type="submit" value="Search"/>
            </form>
        </div>
        <div class="col">
            Number Document
            <form action="/filterNumber" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="text" name="filter" placeholder="serch by number"/>
                <input type="submit" value="Search"/>
            </form>
        </div>
        <div class="col">
            Name Collegue
            <form action="/filterCollegues" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="text" name="filter" placeholder="serch by collegues"/>
                <input type="submit" value="Search"/>
            </form>
        </div>
    </div>
    <table class="table mt-5">
        <tr>
            <th scope="col">#</th>
            <th scope="col">author</th>
            <th scope="col">document_number</th>
            <th scope="col">data</th>
            <th scope="col">performers</th>
            <th scope="col">image</th>
        </tr>

        <tbody>
            <#list registers as register>
                <tr>
                    <th scope="row">#</th>
                    <td>${register.getAuthor().username?ifExists}</td>
                    <td>${register.getDoc().number?ifExists}</td>
                    <td>${register.start?ifExists}</td>
                    <td>
                        <#list register.getColl() as collegue>
                            ${collegue.name?ifExists}<#sep>,
                        </#list>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample${register.id}" aria-expanded="false" aria-controls="collapseExample">
                            show img
                        </button>
                        <div class="collapse" id="collapseExample${register.id}">
                            <div class="card card-body">
                                <#if register.getDoc().img??>
                                    <img src="/img/${register.getDoc().img}">
                                </#if>
                            </div>
                        </div>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</@dom.dom>