<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-from-label"> User Name : </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="username" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-from-label"> Password : </label>
            <div class="col-sm-6">
                <input class="form-control" type="password" name="password" placeholder="Password"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit" value="Sign In">Sing in</button>
    </form>
</#macro>

<#macro logaut>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary" type="submit">Sign Out</button>
        </form>
    </div>
</#macro>