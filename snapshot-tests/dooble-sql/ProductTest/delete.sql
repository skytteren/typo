delete from "production"."product"  where  coalesce((productid  = ? ) , ? ) 