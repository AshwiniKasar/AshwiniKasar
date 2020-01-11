function validateform()
{
    var title=document.forms["editmovieitem"]["title"].value;
    if(title=="")
    {
        alert("Title is required");
        return false;

    }

    var titlelength=title.length;
    if(titlelength<2 || titlelength>100)
    {
        alert("title should have 2 to 100 characters");
        return false;
    }
    
    var gross=document.forms["editmovieitem"]["gross"].value;
    if(isNaN(gross))
    {
        alert("Box-office has to be in a number");
        return false;
    }

    if(gross=="")
    {
        alert("Box-office is required");
        return false;
    }

    var dateofLounch=document.forms["editmovieitem"]["dateofLounch"].value;
    if(dateofLounch=="")
    {
        alert("date of lounch is required");
        return false;

    }
    if(!dateofLounch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/)){
        alert("incorrect date format.expected(dd/mm/yy)");
        return false;
    }

    var genre=document.forms["editmovieitem"]["genre"].value;
    
        if(genre==0)
        {
            alert("Select one Genere");
            return false;
        }
}

