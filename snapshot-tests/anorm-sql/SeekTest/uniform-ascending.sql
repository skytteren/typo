with 
product0 as (
  (select product0 from production.product product0 where (((product0).name,(product0).weight,(product0).listprice) > (?::"public"."Name",?::DECIMAL,?::DECIMAL)) order by (product0).name ASC , (product0).weight ASC , (product0).listprice ASC )
)
select (product0)."productid",(product0)."name",(product0)."productnumber",(product0)."makeflag",(product0)."finishedgoodsflag",(product0)."color",(product0)."safetystocklevel",(product0)."reorderpoint",(product0)."standardcost",(product0)."listprice",(product0)."size",(product0)."sizeunitmeasurecode",(product0)."weightunitmeasurecode",(product0)."weight",(product0)."daystomanufacture",(product0)."productline",(product0)."class",(product0)."style",(product0)."productsubcategoryid",(product0)."productmodelid",(product0)."sellstartdate"::text,(product0)."sellenddate"::text,(product0)."discontinueddate"::text,(product0)."rowguid",(product0)."modifieddate"::text from product0