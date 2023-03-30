function checkPassword(valor){
    var myregex = /^(?=\w*\d)(?=\w*[a-z])\S{4,16}$/; 
   if(myregex.test(valor)){
       alert(valor+" es valido!");
       return true;        
   }else{
      alert(valor+" NO es valido!");
       return false;        
   }   
 }

  function checkForm(form){
    if(form.email.value == "") {
      alert("Error: Debe escribir Usuario!");
      form.email.focus();
      return false;
    }
   
   if(checkPassword(form.pwd1.value)) {
    if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
      this.submit();
      }
    } else {
      alert("Error: las contraseñas no coinciden!");
      form.pwd1.focus();
      return false;
}
    
  }
  
  