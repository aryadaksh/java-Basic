<%@ page import="java.util.Date,java.util.TimeZone" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flipkart Clone</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:#f1f3f6;
}

/* NAVBAR */
.navbar{
    background:linear-gradient(90deg,#2874f0,#0059d6);
    height:70px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 50px;
    color:white;
    position:sticky;
    top:0;
    z-index:100;
    box-shadow:0 2px 10px rgba(0,0,0,0.2);
}

.logo{
    font-size:30px;
    font-weight:bold;
}

.logo span{
    color:#ffe500;
}

.search{
    width:45%;
}

.search input{
    width:100%;
    padding:12px;
    border:none;
    border-radius:30px;
    outline:none;
    font-size:15px;
}

.nav-links a{
    text-decoration:none;
    color:white;
    margin-left:25px;
    font-weight:bold;
    transition:.3s;
}

.nav-links a:hover{
    color:#ffe500;
}

/* SERVER INFO */
.info{
    background:white;
    width:95%;
    margin:15px auto;
    padding:15px;
    border-radius:10px;
    box-shadow:0 2px 8px rgba(0,0,0,.1);
}

/* HERO */
.hero{
    width:95%;
    height:350px;
    margin:20px auto;
    border-radius:15px;
    overflow:hidden;
    color:white;
    display:flex;
    align-items:center;
    justify-content:center;
    flex-direction:column;
    background:linear-gradient(135deg,#2874f0,#6a11cb);
    box-shadow:0 5px 15px rgba(0,0,0,.2);
}

.hero h1{
    font-size:55px;
}

.hero p{
    margin-top:10px;
    font-size:20px;
}

.hero button{
    margin-top:20px;
    padding:12px 25px;
    border:none;
    background:white;
    color:#2874f0;
    font-size:16px;
    border-radius:25px;
    cursor:pointer;
    font-weight:bold;
}

/* CATEGORY */
.categories{
    width:95%;
    margin:20px auto;
    display:grid;
    grid-template-columns:repeat(6,1fr);
    gap:15px;
}

.category{
    background:white;
    padding:20px;
    text-align:center;
    border-radius:15px;
    transition:.3s;
    box-shadow:0 2px 8px rgba(0,0,0,.1);
}

.category:hover{
    transform:translateY(-5px);
}

.cat-icon{
    font-size:40px;
}

.category h4{
    margin-top:10px;
}

/* PRODUCT SECTION */
.section-title{
    width:95%;
    margin:30px auto 10px;
    font-size:28px;
    font-weight:bold;
}

.products{
    width:95%;
    margin:auto;
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
    gap:25px;
}

.card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 3px 12px rgba(0,0,0,.1);
    transition:.3s;
}

.card:hover{
    transform:translateY(-8px);
}

.card img{
    width:100%;
    height:220px;
}

.card-body{
    padding:15px;
}

.card-body h3{
    margin-bottom:10px;
}

.price{
    color:green;
    font-size:22px;
    font-weight:bold;
}

.btn{
    width:100%;
    border:none;
    margin-top:15px;
    background:#ff6f00;
    color:white;
    padding:12px;
    border-radius:8px;
    cursor:pointer;
}

/* FOOTER */
.footer{
    margin-top:40px;
    background:#172337;
    color:white;
    text-align:center;
    padding:30px;
}
</style>

</head>
<body>

<!-- NAVBAR -->
<div class="navbar">
    <div class="logo">Flip<span>kart</span></div>

    <div class="search">
        <input type="text" placeholder="Search for products, brands and more...">
    </div>

    <div class="nav-links">
        <a href="#">Login</a>
        <a href="#">Cart</a>
        <a href="#">Seller</a>
    </div>
</div>

<!-- SERVER INFO -->
<div class="info">
    <h3>Server Information</h3>
    <p><b>Current Time:</b> <%= new Date() %></p>
    <p><b>Time Zone:</b> <%= TimeZone.getDefault().getID() %></p>
</div>

<!-- HERO -->
<div class="hero">
    <h1>Big Billion Days</h1>
    <p>Up To 80% Off On Electronics & Fashion</p>
    <button>Shop Now</button>
</div>

<!-- CATEGORY -->
<div class="categories">

    <div class="category">
        <div class="cat-icon">📱</div>
        <h4>Mobiles</h4>
    </div>

    <div class="category">
        <div class="cat-icon">💻</div>
        <h4>Laptops</h4>
    </div>

    <div class="category">
        <div class="cat-icon">🎧</div>
        <h4>Electronics</h4>
    </div>

    <div class="category">
        <div class="cat-icon">👕</div>
        <h4>Fashion</h4>
    </div>

    <div class="category">
        <div class="cat-icon">🏠</div>
        <h4>Home</h4>
    </div>

    <div class="category">
        <div class="cat-icon">⚽</div>
        <h4>Sports</h4>
    </div>

</div>

<h2 class="section-title">Best Deals For You</h2>

<!-- PRODUCTS -->
<div class="products">

    <div class="card">
        <img src="https://picsum.photos/300/220?1">
        <div class="card-body">
            <h3>iPhone 15</h3>
            <p class="price">₹69,999</p>
            <button class="btn">Add To Cart</button>
        </div>
    </div>

    <div class="card">
        <img src="https://picsum.photos/300/220?2">
        <div class="card-body">
            <h3>Gaming Laptop</h3>
            <p class="price">₹89,999</p>
            <button class="btn">Add To Cart</button>
        </div>
    </div>

    <div class="card">
        <img src="https://picsum.photos/300/220?3">
        <div class="card-body">
            <h3>Smart Watch</h3>
            <p class="price">₹2,999</p>
            <button class="btn">Add To Cart</button>
        </div>
    </div>

    <div class="card">
        <img src="https://picsum.photos/300/220?4">
        <div class="card-body">
            <h3>Bluetooth Headphones</h3>
            <p class="price">₹1,499</p>
            <button class="btn">Add To Cart</button>
        </div>
    </div>

</div>

<div class="footer">
    <h3>Flipkart Clone</h3>
    <p>Created By Daksh using JSP</p>
</div>

</body>
</html>