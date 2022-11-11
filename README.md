
<b> Exceptions added : </b>
    
    IdPresentException  ->  While saving a movie, id must not be present in input field  (400)
    MovieException      ->  Movie is not present in the database (id not found)          (404)
    General exceptions  ->  When the request cannot be placed due to malfunction syntax, 
                            invalid request message framing,or deceptive request routing (400)
    
