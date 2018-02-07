function cleanCell(td)
{
    alert(td.value);
    if(td.value == '0')
    {
        td.innerHTML = '0';
    }
    else
    {
        td.innerHTML = '1';
    }
}