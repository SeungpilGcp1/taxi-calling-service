
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import TaxiCallingServiceTaxiCallManager from "./components/listers/TaxiCallingServiceTaxiCallCards"
import TaxiCallingServiceTaxiCallDetail from "./components/listers/TaxiCallingServiceTaxiCallDetail"
import TaxiCallingServiceRideManager from "./components/listers/TaxiCallingServiceRideCards"
import TaxiCallingServiceRideDetail from "./components/listers/TaxiCallingServiceRideDetail"
import TaxiCallingServicePaymentManager from "./components/listers/TaxiCallingServicePaymentCards"
import TaxiCallingServicePaymentDetail from "./components/listers/TaxiCallingServicePaymentDetail"
import TaxiCallingServiceReviewManager from "./components/listers/TaxiCallingServiceReviewCards"
import TaxiCallingServiceReviewDetail from "./components/listers/TaxiCallingServiceReviewDetail"

import DriverManagementServiceDriverManager from "./components/listers/DriverManagementServiceDriverCards"
import DriverManagementServiceDriverDetail from "./components/listers/DriverManagementServiceDriverDetail"





export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/taxiCallingServices/taxiCalls',
                name: 'TaxiCallingServiceTaxiCallManager',
                component: TaxiCallingServiceTaxiCallManager
            },
            {
                path: '/taxiCallingServices/taxiCalls/:id',
                name: 'TaxiCallingServiceTaxiCallDetail',
                component: TaxiCallingServiceTaxiCallDetail
            },
            {
                path: '/taxiCallingServices/rides',
                name: 'TaxiCallingServiceRideManager',
                component: TaxiCallingServiceRideManager
            },
            {
                path: '/taxiCallingServices/rides/:id',
                name: 'TaxiCallingServiceRideDetail',
                component: TaxiCallingServiceRideDetail
            },
            {
                path: '/taxiCallingServices/payments',
                name: 'TaxiCallingServicePaymentManager',
                component: TaxiCallingServicePaymentManager
            },
            {
                path: '/taxiCallingServices/payments/:id',
                name: 'TaxiCallingServicePaymentDetail',
                component: TaxiCallingServicePaymentDetail
            },
            {
                path: '/taxiCallingServices/reviews',
                name: 'TaxiCallingServiceReviewManager',
                component: TaxiCallingServiceReviewManager
            },
            {
                path: '/taxiCallingServices/reviews/:id',
                name: 'TaxiCallingServiceReviewDetail',
                component: TaxiCallingServiceReviewDetail
            },

            {
                path: '/driverManagementServices/drivers',
                name: 'DriverManagementServiceDriverManager',
                component: DriverManagementServiceDriverManager
            },
            {
                path: '/driverManagementServices/drivers/:id',
                name: 'DriverManagementServiceDriverDetail',
                component: DriverManagementServiceDriverDetail
            },






    ]
})
