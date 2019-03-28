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
            email: 'aoursouene@gmail.com' ,
            fb: 'https://www.facebook.com/oursouene.ayari' ,
            lin: 'https://www.linkedin.com/in/mohamed-oursouene-ayari-53b879154/' },

        {   name : 'Marriem Aouadi' ,
            post : 'VP' ,
            image: 'VP.jpg',
            quote: '" Se réunir est un début, rester ensemble est un progrès, travailler ensemble est la réussite "' ,
            tel: '+216 21 348 405',
            email: 'mariem.aouadi.ma@gmail.com',
            fb: 'https://www.facebook.com/mariem.aouadi' ,
            lin: 'http://linkedin.com/in/mariem-aouadi-09a09814a' },

        {   name : 'Noura Bouthour' ,
            post : 'SG' ,
            image: 'SG.JPG',
quote: '"  Chaque bonne réalisation, grande ou petite, connait ses périodes de corvées et de triomphes;'
+ ' un début, un combat et une victoire."' ,
            tel: '+216 27 270 104',
            email: 'nourabouthour@gmail.com' ,
            fb: 'https://www.facebook.com/profile.php?id=100001893592104' ,
            lin: 'https://www.linkedin.com/in/noura-bouthour-759125183' },

        {   name : 'Marwen Rezgui' ,
            post : 'Trésorier' ,
            image: 'tresorier.JPG',
            quote: '" Je suis un guerrier et un insatisfait permanent, c\'est ça l\'apanage du champion. "' ,
            tel: '+216 25 601 877',
            email: 'rezgui.marouen.12@gmail.com' ,
            fb: 'https://www.facebook.com/m.cl.r.ca' ,
            lin: 'https://www.linkedin.com/in/marouen-rezgui-56851214b' },




        {   name : 'Maya Ben salem' ,
            post : 'Responsable Partenariats' ,
            image: 'partenariat.JPG',
            quote: '" Tout est possible à qui rêve, ose, travaille et n\'abandonne jamais "' ,
            tel: '+216 53 530 405',
            email: 'maya.bsalem@gmail.com' ,
            fb: 'https://www.facebook.com/mayouta.bensalem' ,
            lin: 'https://www.linkedin.com/in/maya-ben-salem-387876152' },

        {   name : 'Manel Ben Lakhdher' ,
            post : 'Responsable Logistique' ,
            image: 'logistique.JPG',
            quote: '" Quoi que tu rêves d’entreprendre, commence-le. L’audace a du génie, du pouvoir, de la magie. "' ,
            tel: '+216 56 302 634',
            email: 'benlakhdar.manel.gm@gmail.com' ,
            fb: 'https://facebook.com/manel.benlakhdar.39?ref=bookmarks' ,
            lin: 'https://www.linkedin.com/in/manel-ben-lakhdar-aa154a153' },

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
            email: 'firaseltaief1925@gmail.com',
            fb: 'https://www.facebook.com/eeltaief ' ,
            lin: 'https://www.linkedin.com/in/firas-eltaief-448988147/' },

        {   name : 'Meriam Bettaieb' ,
            post : 'Responsable Projets et prospection' ,
            image: 'projet%20et%20prospection.JPG',
            quote: '" C\'est votre attitude, bien plus que votre aptitude, qui détermine votre altitude."' ,
            tel: '+216 50 660 123',
            email: 'Meriam2.8bettaieb@gmail.com' ,
            fb: 'https://www.facebook.com/meriam.bettaieb ' ,
            lin: 'https://www.linkedin.com/in/meriam-betta%C3%AFeb-035b08154/' },
    ];
  constructor() { }

  ngOnInit() {}

}
