import { Name } from './../home';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  myName: Name = {
    name: 'From Home with the Name object',
  };

  constructor() {}

  ngOnInit(): void {}
}
