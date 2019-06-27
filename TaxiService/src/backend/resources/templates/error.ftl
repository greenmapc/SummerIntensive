<#import "macros/layout.ftl" as l>
<#import "macros/navbar.ftl" as n>
<@l.layout "Error" "login">
    <@n.navbar/>
    <div class="position">
        <div class="layout-positioner over-bootstrap__form flex__form">
            <h1>Упс! <a href="/panel" style="text-decoration: none; color: deepskyblue">На главную</a></h1>
            <table>
                <tr>
                    <td><b>Path</b></td>
                    <td>${path}</td>
                </tr>
                <tr>
                    <td><b>Error</b></td>
                    <td>${error}</td>
                </tr>
                <tr>
                    <td><b>Status</b></td>
                    <td>${status}</td>
                </tr>
                <tr>
                    <td><b>Message</b></td>
                    <td>${message}</td>
                </tr>
            </table>
        </div>
    </div>
</@l.layout>