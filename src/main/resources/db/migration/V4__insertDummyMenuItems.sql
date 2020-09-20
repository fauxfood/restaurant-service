INSERT INTO menu_items (name,description,price_cents,restaurant_id) VALUES
('Three fish tacos', 'flakey chunks of breaded tilapia nestled on a bed of cabbage','795',(select id from restaurants WHERE slug='taqdelsol')),
('Pastor burrito', 'Rich marinaded al pastor pork, wrapped in buttery soft tortilla','895',(select id from restaurants WHERE slug='taqdelsol')),
('Quesadilla con legumbres', 'Cheesy cheese, grilled veggies, and tortilla, all smushed together','550',(select id from restaurants WHERE slug='taqdelsol')),
('La torta milanesa', 'Grilled cheese sandwich, featuring breaded pork','400',(select id from restaurants WHERE slug='taqdelsol')),
('Flan', 'Custardy delight, topped with rich caramel deliciousness','400',(select id from restaurants WHERE slug='taqdelsol'))
;