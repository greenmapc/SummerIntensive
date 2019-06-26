<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Список актов передачи" "">
    <@n.navbar/>
    <div class="container">
        <#if acts??>
            <#list acts as act>

            </#list>
        <#else>
            <h3>Акты приема-передачи отсутствуют</h3>
        </#if>
    </div>
</@l.layout>