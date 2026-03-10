let binToDec list =
  let folder acc bit =
    if bit = 0 || bit = 1 then
      acc * 2 + bit
    else
      invalid_arg "Lista zawiera cyfrę inną niż 0 lub 1"
  in
  List.fold_left folder 0 list;;

binToDec [1;1;1;0];;
binToDec [];;
binToDec [0];;
binToDec [2;0;1;0;1];;
binToDec [0;0;1;0;0;0];;