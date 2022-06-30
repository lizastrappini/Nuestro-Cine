
function cerrarSesion(){
	Swal.fire({
  title: 'Seguro que quieres cerrar sesion?',
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#dc3545',
  cancelButtonColor: '#198754',
  confirmButtonText: 'Si, cerrar sesion'
  
}).then((result) => {
  if (result.isConfirmed) {
       window.location = "SignOut" ;
    
  }
})
};


function cambiarContra(){
  Swal.fire({
    title: 'entre 8 y 16 caracteres,al menos un dígito, al menos una minúscula y al menos una mayúscula',
    html:
    '<form name="cambio" action="CambiarPassword" method="POST" >'+
    '<input id="passoriginal" name="passoriginal" class="swal2-input" type="password" placeholder="contrasenia actual">' +
    '<input id="pass1" name="pass1" class="swal2-input" type="password" placeholder="contrasenia nueva">' +
     '<input id="pass2" name="pass2" class="swal2-input" type="password" placeholder="repita la contrasenia">'+    
     '</form>',
      focusConfirm: false,   
  }).then((result) => {
  if(result.isConfirmed){
	checkForm(cambio);   
    }
    })
}

  function checkPassword(valor){
    var myregex = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/; 
   if(myregex.test(valor)){
       alert(valor+" es valido!");
       return true;        
   }else{
      alert(valor+" NO es valido!");
       return false;
       
               
   }   
 }

  function checkForm(cambio){
 
   
   if(checkPassword(cambio.pass1.value)) {
    if(cambio.pass1.value != "" && cambio.pass1.value == cambio.pass2.value) {
      cambio.submit();
      }
    } else {
      alert("Error: las contraseñas no coinciden!");
      cambio.pass1.focus();
      return false;
      
}
    
  }
  
function borrarEntrada(){
	Swal.fire({
  title: 'Seguro que quieres cancelar la entrada?',
  icon: 'warning',
  showCancelButton: false,
  confirmButtonColor: '#dc3545',
  cancelButtonColor: '#198754',
  confirmButtonText: 'Si, cancelar' ,
  focusConfirm: false,
  return:false,
}).then((result) => {	
  if (result.isConfirmed) {
	document.cancelarEntrada.submit();         
  }
})
};
/**
 * 
 */