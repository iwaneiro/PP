let rec repeat x n acc =
  if n<=0 then acc
  else repeat x (n-1) (x::acc)

let duplicate lista liczniki =
  let rec aux l c acc =
    match (l, c) with
    | ([], _) -> List.rev acc (* Koniec danych - zwracamy odwrócony wynik *)
    | (_, []) -> List.rev acc (* Koniec liczników - zwracamy wynik *)
    | (h1 :: t1, h2 :: t2) ->
        if h2 < 0 then failwith "Błąd: Liczba powtórzeń nie może być ujemna"
        else 
          (* Dodajemy h1 powielone h2 razy do akumulatora i rekurencyjnie przetwarzamy resztę *)
          let new_acc = repeat h1 h2 acc in
          aux t1 t2 new_acc
  in
  aux lista liczniki [];;



duplicate [1;2;3] [0;3;1;4];;
duplicate [] [1;2];;
duplicate [1;2] [];;
duplicate [1;2] [1;2];;