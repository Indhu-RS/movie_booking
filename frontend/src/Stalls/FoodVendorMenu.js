import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

export default function FoodVendorMenu() {
    const { id } = useParams(); // Extract vendorId from URL params

    const [menuData, setMenuData] = useState(null);
    const [quantity, setQuantity] = useState(0);
    const [seatNumber, setSeatNumber] = useState('');
    const [paymentMethod, setPaymentMethod] = useState('');
    const [totalPrice, setTotalPrice] = useState(0);

    useEffect(() => {
        const loadMenuData = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/foodvendors/${id}`);
                const menu = response.data.menu;
                setMenuData(menu);
            } catch (error) {
                console.error("Error loading menu data:", error);
            }
        };

        loadMenuData();
    }, [id]);

    useEffect(() => {
        // Calculate total price whenever quantity changes
        setTotalPrice(menuData ? quantity * menuData.price : 0);
    }, [quantity, menuData]);

    const handleIncrement = () => {
        setQuantity(quantity + 1);
    };

    const handleDecrement = () => {
        if (quantity > 0) {
            setQuantity(quantity - 1);
        }
    };

    const handlePaymentMethodChange = (event) => {
        setPaymentMethod(event.target.value);
    };

    const handleSubmit = () => {
        // Display thank you message
        alert("Thank you for your order!");
    };

    return (
        <div className="container">
            <h1 className="my-4">Menu</h1>
            <div className="row row-cols-1 row-cols-md-3 g-4">
                {menuData ? (
                    <div key={menuData.menuId} className="col">
                        <div className="card h-100">
                            <img src={menuData.imageUrl} className="card-img-top" alt={menuData.itemName} />
                            <div className="card-body">
                                <h5 className="card-title">{menuData.itemName}</h5>
                                <p className="card-text">Price: ${menuData.price}</p>
                                {/* Add +/- icons and quantity input */}
                                <div className="d-flex justify-content-between align-items-center">
                                    <div>
                                        Quantity: <input type="number" value={quantity} onChange={(e) => setQuantity(parseInt(e.target.value))} />
                                    </div>
                                    <div>
                                        <button className="btn btn-sm btn-outline-primary me-2" onClick={handleIncrement}>+</button>
                                        <button className="btn btn-sm btn-outline-primary" onClick={handleDecrement}>-</button>
                                    </div>
                                </div>
                                <div className="mt-3">
                                    <input type="text" className="form-control mb-2" placeholder="Enter seat number" value={seatNumber} onChange={(e) => setSeatNumber(e.target.value)} />
                                    <select className="form-select mb-2" value={paymentMethod} onChange={handlePaymentMethodChange}>
                                        <option value="">Select payment method</option>
                                        <option value="upi">UPI</option>
                                        <option value="creditcard">Credit Card</option>
                                    </select>
                                    <button className="btn btn-primary" onClick={handleSubmit}>Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                ) : (
                    <div>No menu items available</div>
                )}
            </div>
            {totalPrice !== null && (
                <div className="mt-3 p-3 bg-primary text-white">Total Price: ${totalPrice}</div>
            )}
        </div>
    );
}
