<template>
    <v-card outlined>
        <v-card-title>
            CallTaxi
        </v-card-title>

        <v-card-text>
            <String label="CustomerId" v-model="value.customerId" :editMode="editMode"/>
            <Address offline label="CurrentLocation" v-model="value.currentLocation" :editMode="editMode" @change="change"/>
            <Address offline label="Destination" v-model="value.destination" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="callTaxi"
            >
                CallTaxi
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CallTaxiCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.customerId = '';
            this.value.currentLocation = {};
            this.value.destination = {};
        },
        watch: {
        },
        methods: {
            callTaxi() {
                this.$emit('callTaxi', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

