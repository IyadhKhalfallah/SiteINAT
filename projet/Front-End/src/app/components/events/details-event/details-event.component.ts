import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-event',
  templateUrl: './details-event.component.html',
  styleUrls: ['./details-event.component.css']
})
export class DetailsEventComponent implements OnInit {

  image: string;
  title: string;
  date: string;
  orgonaziedBy: string[];
  shortDescription: string;
  longDescription: string;
  gallery: string[];

  constructor() { }

  ngOnInit() {
    this.image = 'affiche/forum-6Affiche.jpg';
    this.title = '6 ème édition du forum de l\'emploi et des stages';
    this.date = '14-11-2018';
    this.orgonaziedBy = ['Institut National Agronomique de Tunis ', 'JE INAT'];
    // tslint:disable-next-line:max-line-length
    this.shortDescription = 'L’agriculture tunisienne revêt une importance cruciale de par sa contribution à la sécurité alimentaire et à la garantie d’une activité et d’une source de revenu à la population rurale Dans ce contexte, plusieurs filières phares ont connu un essor appréciable et ont enregistré des performances inédites notamment l’huile d’olive et les dattes';
    // tslint:disable-next-line:max-line-length
    this.longDescription = 'Cependant, en tant que futurs ingénieurs agronomes, nous voulons mettre l\'accent sur les variables qui caractérisent l\'économie tunisienne et qui présentent des influences importantes et différentes selon les produits, Dans le cas tunisien, c\'est le niveau de la production qui détermine les quantités à exporter après satisfaction de la demande locale Pour la plupart des produits, la production vise en priorité le marché intérieur, les exportations ne sont recherchées que dans un deuxième temps De ce fait, la production a peu suivi les nouvelles exigences quantitatives et surtout qualitatives de la demande étrangère, En effet, pour pouvoir exporter nos produits , il faudra adopter ce que l\'on appelle "Les Signes Officiels de Qualité et d\'Origine\": norme en parfaite adéquation avec les aspirations les plus actuelles des consommateurs Cela permet aux producteurs qui le souhaitent de faire reconnaître les qualités particulières de leurs produits tout en apportant aux consommateurs des garanties sur l\'origine des produits et leur mode d\'élaboration ainsi que leurs spécificités, leur traçabilité et leur crédibilité grâce à des contrôles sérieux et précis reposant sur des cahiers des charges stricts dont le respect est régulièrement contrôlé par des organismes agréés par les pouvoirs publics Par ailleurs, les efforts de commercialisation demeurent encore insuffisants. Une nouvelle politique d\'exportation orientée vers la satisfaction des exigences des marchés étrangers reste à mettre en oeuvre pour entretenir les flux d\'exportation et préserver l\'image de marque des produits tunisiens Ainsi, à travers la sixième édition du \"Forum de l\'emploi et des stages\" organisé par l\'INAT Junior Entreprise, plusieurs acteurs et experts du domaine, plus particulièrement les anciens de l\'INAT, seront présents afin de vous en dire plus quant à leur vision stratégique de point de vue exportation. Vous aurez également l\'occasion de visiter les différents stands mis à votre disposition et représentés par les entreprises du domaine agronomique Ils auront le plaisir de vous exposer les différentes offres de stages tout en mettant en avant les prestations de services qu\'ils suggèrent  Nous vous donnons rendez-vous le mercredi 14 Novembre 2018 à l\'Institut National Agronomique de Tunisie à partir de 8h30 pour aborder le thème choisi cette année \" Les exportations agricoles en Tunisie face aux défis de la sécurité alimentaire"';
    // tslint:disable-next-line:max-line-length
    this.gallery = ['gallery/forum-6-1.jpg', 'gallery/forum-6-2.jpg', 'gallery/forum-6-3.jpg', 'gallery/forum-6-4.jpg', 'gallery/forum-6-5.jpg', 'gallery/forum-6-6.jpg', 'gallery/forum-6-7.jpg', 'gallery/forum-6-8.jpg', 'gallery/forum-6-9.jpg', 'gallery/forum-6-10.jpg'];
  }

}
