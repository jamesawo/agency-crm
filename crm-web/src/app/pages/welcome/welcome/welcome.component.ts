import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-welcome',
  template: `
    <p>
      welcome works!
    </p>
  `,
  styles: [
  ]
})
export class WelcomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
