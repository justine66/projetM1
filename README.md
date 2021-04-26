# projet M1
structure secondaire de l'ARN

seance 1 : 
  - creation de la classe ARN 
    - creation du constructeur et des get
    - creation de la methode is_appiered/equals 
    - creation des methodes d'affichage (a completer quand la classe Affichage remplie)
  - creation de la classe Affichage (A remplir) 
  - creation de la classe Arbre (A remplir)
  - creation de la classe Test pour tester les methodes

seance 2 : 
 - Class Arbre Completée
 - Class Affichage demarrée mais a modifier

seance 3 :
- creation de la classe Parser pour recupérer l'appariement a partir d'un fichier Stockholm
- creation de la classe Worker(A modifier)

seances suivantes : 
- creation de la classe user et du fichier user.form (pour faire la partie graphique, remplace la classe Affichage)
- suppression de la classe Affichage
- modification de la classe Worker
- modification de la classe ARN pour que la methode plus_grand_sous_arbre retourne un sous-arbre correct + creation de la methode is_correct
    
pb recontrés :
- pb de redimension de taille de fenetre
- plus_grand_sous_arbre (ne donne pas un sous-arbre correct)

commentaires : 

 - on considère qu'il y a qu'un appariement possible pour le moment mais on pourra reflechir pour travailler avec une liste d'appariement par la suite
 - pour verifié si les structures 2ndaires sont les meme (methode is_appiered) on considere que les deux brins sont de meme longueur mais on pourra le modifier pour qu'il cherche dans une sous partie d'un brin plus grand (methode is_motif)
 - pour afficher l'arbre utiliser une librairie qui le fait
