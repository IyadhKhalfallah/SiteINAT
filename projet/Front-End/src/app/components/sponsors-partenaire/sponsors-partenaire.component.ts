import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sponsors-partenaire',
  templateUrl: './sponsors-partenaire.component.html',
  styleUrls: ['./sponsors-partenaire.component.css']
})
export class SponsorsPartenaireComponent implements OnInit {
  sponsors = [
      { name: 'Président' , image: '_Président_(fromage).png'},
      { name: 'Agil' , image: 'Agil.png'},
      { name: 'Alfa' , image: 'Alfa.png'},
      { name: 'APIA' , image: 'APIA.png'},
      { name: 'B lounge' , image: 'B lounge.jpg'},
      {name: 'Bayer' , image: 'Bayer.png'},
      { name: 'Ben Yedder' , image: 'Ben Yedder.png'},
      { name: 'BFI' , image: 'BFI.png'},
      { name: 'BIAT' , image: 'BIAT.png'},
      { name: 'BNA' , image: 'BNA.png'},
      { name: 'Cogite' , image: 'Cogite.png'},
      { name: 'Comete Engineering' , image: 'Comete Engineering.png'},
      { name: 'ILMS' , image: 'ILMS.png'},
      { name: 'IMS' , image: 'IMS.png'},
      { name: 'SCET' , image: 'logo-SCET.svg'},
      { name: 'Mabrouka' , image: 'Mabrouka.png'},
      { name: 'OHN' , image: 'ONH.png'},
      { name: 'Orange Tunisie' , image: 'Orange-Tunisie_logo.png'},
      { name: 'OVITA' , image: 'OVITA.png'},
      { name: 'RED bull' , image: 'RED bull.png'},
      { name: 'Ruspina' , image: 'Ruspina.png'},
      { name: 'Sadira' , image: 'Sadira.png'},
      { name: 'SFBT' , image: 'SFBT.png'},
      { name: 'SNA' , image: 'SNA.png'},
      { name: 'STB' , image: 'STB.png'},
      { name: 'Toast' , image: 'Toast.jpg'},
      { name: 'Toyota' , image: 'Toyota.png'},
      { name: 'Tunisie Telecom' , image: 'tunisie-teleco.png'},
      { name: 'UTAP' , image: 'UTAP.png'},
      { name: 'Vitalait' , image: 'vitalait.png'}
      ];
  partners = [
      { name: 'CAP FM', image: 'CAP FM.png'},
      { name: 'Express FM', image: 'Express_FM.png'},
      { name: 'IFM', image: 'IFM.png'},
      { name: 'Jawhara FM', image: 'Jawhara Fm.png'},
      { name: 'Mosaique FM', image: 'Mosaique Fm.png'},
      { name: 'Radio Nationale', image: 'Radio Nationale.png'},
      { name: 'RTCI', image: 'RTCI.png'},
      { name: 'Saraha FM', image: 'Saraha FM.png'},

  ];

  constructor() { }

  ngOnInit() {
  }

}
