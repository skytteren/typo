with 
product0 as (
  (select product0 from production.product product0 where ((((product0).class = ?::VARCHAR) AND (((product0).daystomanufacture > ?::INTEGER) OR ((product0).daystomanufacture <= ?::INTEGER))) AND ((product0).productline = ?::VARCHAR)))
),
unitmeasure0 as (
  (select unitmeasure0 from production.unitmeasure unitmeasure0 where ((unitmeasure0).name LIKE ?::VARCHAR))
),
join_cte0 as (
  select product0, unitmeasure0
  from product0
  join unitmeasure0
  on ((product0).sizeunitmeasurecode = (unitmeasure0).unitmeasurecode)
  
),
productmodel0 as (
  (select productmodel0 from production.productmodel productmodel0 )
),
left_join_cte0 as (
  select product0, unitmeasure0, productmodel0
  from join_cte0
  left join productmodel0
  on ((product0).productmodelid = (productmodel0).productmodelid)
  where ((product0).productmodelid = (productmodel0).productmodelid) order by (product0).productmodelid ASC , (productmodel0).name DESC NULLS FIRST
)
select (product0)."productid",(product0)."name",(product0)."productnumber",(product0)."makeflag",(product0)."finishedgoodsflag",(product0)."color",(product0)."safetystocklevel",(product0)."reorderpoint",(product0)."standardcost",(product0)."listprice",(product0)."size",(product0)."sizeunitmeasurecode",(product0)."weightunitmeasurecode",(product0)."weight",(product0)."daystomanufacture",(product0)."productline",(product0)."class",(product0)."style",(product0)."productsubcategoryid",(product0)."productmodelid",(product0)."sellstartdate"::text,(product0)."sellenddate"::text,(product0)."discontinueddate"::text,(product0)."rowguid",(product0)."modifieddate"::text,(unitmeasure0)."unitmeasurecode",(unitmeasure0)."name",(unitmeasure0)."modifieddate"::text,(productmodel0)."productmodelid",(productmodel0)."name",(productmodel0)."catalogdescription",(productmodel0)."instructions",(productmodel0)."rowguid",(productmodel0)."modifieddate"::text from left_join_cte0