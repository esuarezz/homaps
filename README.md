**Implementation of homaps**<
    
                
 Application that helps to people to find a place where to live based
 on the places where the user spend time and visit, and the homes
 where 
                
                
 ----------------             
 Solutions:               
 
 Just is returning based on the homes introduced, can rate the best of 
 the homes introduced.
 future: 
 using an API to get flats from Rental places
 generate a polygon where you can see the best zone
                
                
 ----------------         
                
  TODO (Next):              
  
  Technologies
  - Add swagger to document the API
  - Add Trello - Kanban
  
          
 Json example from form to work with just locations from input:
{
    "isResponseOnlyOnList": true,
	"locations": [{
		"type": "Home",
		"name": "Barcelona, España",
		"coordenade": "1233,151515",
		"price": 399
	},{
		"type": "Home",
		"name": "Segovia, España",
		"coordenade": "122121,1221212",
		"price": 399
	} ,{
		"type": "Poi",
		"name": "Madrid, España",
		"coordenade": "122121,1221212",
		"frecuency": 2,
		"relevance": 5
	}]

}
	
	Application will not work cause of properties is not uploaded
	the same for test.
	
    Continuous integration working fine