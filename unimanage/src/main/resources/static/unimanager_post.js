async function unimanager() {

     try {
          let name = document.getElementById("name").value;
          let email = document.getElementById("email").value;
          let birthDate = document.getElementById("birthDate").value;
          let gender = document.querySelector('input[name="gender"]:checked').value ;
          let res = await $.ajax({ 
              url: "/api/students/"+name+","+birthDate+","+gender+","+email, 
              method: "post", 
              dataType: "text" 
            }); 
            document.getElementById("message").innerHTML = res; 
        } catch (error) { console.log(error); } 
    
}