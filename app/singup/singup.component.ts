import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../authenticaton-service.service';
import { Admin } from '../Admin';



@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SingupComponent {

  constructor(private service: AuthenticationServiceService, private router:Router)
  {

  }

  user:any;

  saveUser( userName:any, dob:any, email:any, adminPassword:any, repassword:any, about:any)
  {
    if(adminPassword==repassword)
    {
      this.user=new Admin(userName,adminPassword,email,dob,about,"ADMIN");
      console.log(this.user)
      this.service.signup(this.user).subscribe(

      response => {
        console.log(response);
        alert('Signup successful!!');
        this.router.navigate(['login']);
    },
    (error) => { alert(error.message);  }


   );
   
  }
  else
  {
    alert('password does not match!!');
    window.location.reload();
  }
  }


}
