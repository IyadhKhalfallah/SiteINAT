import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structure',
  templateUrl: './structure.component.html',
  styleUrls: ['./structure.component.css']
})
export class StructureComponent implements OnInit {
    members = [
        {   name : 'Mohamed Oursouene Ayari' ,
            post : 'Président' ,
            image: 'president.JPG',
            quote: '"  Plus le combat est grand plus la victoire est immense "' ,
            tel: '+216 25 865 393' ,
            email: 'aoursouene@gmail.com' },

        {   name : 'Marriem Aouadi' ,
            post : 'VP' ,
            image: 'VP.jpg',
            quote: '" Se réunir est un début, rester ensemble est un progrès, travailler ensemble est la réussite "' ,
            tel: '+216 21 348 405',
            email: 'mariem.aouadi.ma@gmail.com'},

        {   name : 'Noura Bouthour' ,
            post : 'SG' ,
            image: 'SG.JPG',
quote: '"  Chaque bonne réalisation, grande ou petite, connait ses périodes de corvées et de triomphes;'
+ ' un début, un combat et une victoire."' ,
            tel: '+216 27 270 104',
            email: 'nourabouthour@gmail.com' },

        {   name : 'Marwen Rezgui' ,
            post : 'Trésorier' ,
            image: 'tresorier.JPG',
            quote: '" Je suis un guerrier et un insatisfait permanent, c\'est ça l\'apanage du champion. "' ,
            tel: '+216 25 601 877',
            email: 'rezgui.marouen.12@gmail.com' },




        {   name : 'Maya Ben salem' ,
            post : 'Responsable Partenariats' ,
            image: 'partenariat.JPG',
            quote: '" Tout est possible à qui rêve, ose, travaille et n\'abandonne jamais "' ,
            tel: '+216 53 530 405',
            email: 'maya.bsalem@gmail.com' },

        {   name : 'Manel Ben Lakhdher' ,
            post : 'Responsable Logistique' ,
            image: 'logistique.JPG',
            quote: '" Quoi que tu rêves d’entreprendre, commence-le. L’audace a du génie, du pouvoir, de la magie. "' ,
            tel: '+216 56 302 634',
            email: 'benlakhdar.manel.gm@gmail.com' },

        /*{   name : 'Yasmin Mbarki' ,
            post : 'Responsable RH et Formations' ,
            image: 'rh%20et%20formation.JPG',
            quote: '" Si vous pouvez le rêver, vous pouvez le faire. "' ,
            tel: '+216 58 464 742',
            email: 'yasmin.mbarki96@gmail.com' },*/

        {   name : 'Phyras Eltaief' ,
            post : 'Responsable Communication' ,
            image: 'communication.jpg',
            quote: '" Aller vers l’infini, ce n’est pas seulement avancer très loin, c’est avancer éternellement. "' ,
            tel: '+216 225 641 622',
            email: 'firaseltaief1925@gmail.com'},

        {   name : 'Meriam Bettaieb' ,
            post : 'Responsable Projets et prospection' ,
            image: 'projet%20et%20prospection.JPG',
            quote: '" C\'est votre attitude, bien plus que votre aptitude, qui détermine votre altitude."' ,
            tel: '+216 50 660 123',
            email: 'Meriam2.8bettaieb@gmail.com' },
    ];
  constructor() { }

  ngOnInit() {}

}
