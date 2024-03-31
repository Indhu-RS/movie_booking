import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function FoodVendorPage() {
    const [vendors, setVendors] = useState([]);

    useEffect(() => {
        // Fetch list of food vendors
        const fetchVendors = async () => {
            try {
                const response = await axios.get('http://localhost:8080/foodvendors');
                setVendors(response.data);
            } catch (error) {
                console.error("Error fetching food vendors:", error);
            }
        };

        fetchVendors();
    }, []);

    return (
        <div className="container">
            <h1 className="my-4">Food Vendors</h1>
            <div className="row row-cols-1 row-cols-md-3 g-4">
                {vendors.map(vendor => (
                    <div key={vendor.id} className="col">
                        <div className="card h-100">
                            <div className="card-body">
                                <h5 className="card-title">{vendor.shopName}</h5>
                                <p className="card-text">Open Time: {vendor.openTime} - Close Time: {vendor.closeTime}</p>
                            </div>
                            <div className="card-footer">
                                <Link to={`/menu/${vendor.id}`} className="btn btn-primary">View Menu</Link>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}
