$(document).ready(function(){
    $(PrimeFaces.escapeClientId('formUsuario:rut')).Rut({
  on_error: function(){ alert('Rut incorrecto'); }
});
    $(PrimeFaces.escapeClientId('formUsuarioDelete:rut')).Rut({
  on_error: function(){ alert('Rut incorrecto'); }
});
    $(PrimeFaces.escapeClientId('formUsuarioUpdate:rut')).Rut({
  on_error: function(){ alert('Rut incorrecto'); }
});
 });