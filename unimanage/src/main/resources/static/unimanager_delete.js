async function unimanager_del() {

    try {
         let number = document.getElementById("number").value;
         let res = await $.ajax({ 
             url: "/api/students/"+number, 
             method: "delete", 
             dataType: "text" 
           }); 
           document.getElementById("message").innerHTML = res; 
       } catch (error) { console.log(error); } 
   
}