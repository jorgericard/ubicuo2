function populate(s1,s2)
{
    var s1 = document.getElementById(s1);
    var s2 = document.getElementById(s2);

    s2.innerHTML = "";
                         
    if(s1.value == 'bomberos')
    {
        var optionArray = ['|Ingresa tu cargo','cabo|Cabo','cabo primero|Cabo primero',
        'sargento|Sargento','suboficialpricipal|Suboficialprincipal',
        'suboficialmayor|Suboficialmayor','oficial ayudante|Oficial Ayudante',
        'oficial inspector|Oficial inspector','oficial principal|Oficial principal',
        'subcomandante|Subcomandante','comandante|Comandante','comandante mayor|Comandante mayor'
        ,'comandante general|Comandante general'];
    }
    else if(s1.value == 'primeros auxilios')
    {
        var optionArray = ['|Ingresa tu cargo','doctor|Doctor',
        'enfermero|Enfermero','coductor|Conductor'];
    }
    else if(s1.value == 'seguridad ciudadana')
    {
        var optionArray = ['|Ingresa tu cargo','policia|Policia',
        'oficial de policia|Oficial de policia','subinspector|Subinspector',
        'inspector|Inspector','inspector jefe|Inspector jefe',
        'comisario|Comisario','comisario principal|Comisario principal'];
    }

    for (var option in optionArray)
    {
        var pair = optionArray[option].split("|");
        var newoption = document.createElement("option");

        newoption.value = pair[0];
        newoption.innerHTML = pair[1];
        s2.options.add(newoption);
    }

}                 