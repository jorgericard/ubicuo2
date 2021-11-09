function Enebled(checkbox1)
{
    var ddl1 = document.getElementById("opcion_uno");
    var ddl2 = document.getElementById("opcion_dos");
    ddl1.disabled = checkbox1.checked ? false : true;
    ddl2.disabled = checkbox1.checked ? false : true;
    
    if (!ddl1.disabled && !ddl2.disabled)
    {
        ddl1.focus();
        ddl2.focus();
    }

}                   